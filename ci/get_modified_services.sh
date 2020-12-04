COMMIT_RANGE=${COMMIT_RANGE:-$(git merge-base origin/main HEAD)".."}

# Go to the root of the repo
cd "$(git rev-parse --show-toplevel)"

# Get a list of the current files in package form by querying Bazel.
files=()
for file in $(git diff --name-only ${COMMIT_RANGE} ); do
  echo $(bazel query $file)
done

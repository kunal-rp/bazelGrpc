COMMIT_RANGE=${COMMIT_RANGE:-$(git merge-base origin/main HEAD)".."}

# Go to the root of the repo
cd "$(git rev-parse --show-toplevel)"

# Get a list of the current files in package form by querying Bazel.
files=()
echo "STEP 1: Files -> SRC File Targets"
for file in $(git diff --name-only ${COMMIT_RANGE} ); do
   files+=($(bazel query --noshow_progress $file))
done

modified_push_targets=()
echo "STEP 2: Retrieve Push Targets"
for file in ${files[*]}; do
   modified_push_targets+=($(bazel query --noshow_progress "kind(".*push.*", rdeps(//..., set(${file})))"))
done

echo "STEP 3: Running Push Targets"
for target in ${modified_push_targets[*]}; do
   $(SERVICE_TARGET=${target} bazel run //ci:alter_service_config)
   $(bazel run ${target})
   echo "DONE: ${target}" 
done

#TODO: have shell script to run in build & test to check that there is a mapping of push targets => tags and repo
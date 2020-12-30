COMMIT_RANGE=${COMMIT_RANGE:-$(git merge-base origin/main HEAD)".."}

SERVICE_CONFIG_FILE="ci/service_configs.bzl" 

# check to ensure specific files are not modified in change

# Go to the root of the repo
cd "$(git rev-parse --show-toplevel)"

# Get a list of the current files in package form by querying Bazel.
echo "STEP 1: Files -> SRC File Targets"
for file in $(git diff --name-only ${COMMIT_RANGE} ); do
    if [ ${file} = SERVICE_CONFIG_FILE]; then
        printf "Service Config should not be modified"
        exit 1c
    fi
done

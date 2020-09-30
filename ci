#!/usr/bin/env bash

# When this script is triggered by Gerrit's patchset-updated hook (for example)
# you can replace origin/master in the COMMIT_RANGE variable initialization
# with the branch passed as argument to the hook. When using Jenkins with the
# Gerrit Trigger Plugin, use $GERRIT_BRANCH instead. This would make it
# possible to have the Verified label on Gerrit patchsets populated as fast
# as possible.
# For a ref-updated event, use "${GERRIT_OLDREV}..${GERRIT_NEWREV}" as the
# value for COMMIT_RANGE.
# When running in Travis-CI, you can directly use the $TRAVIS_COMMIT_RANGE
# environment variable.

COMMIT_RANGE=${COMMIT_RANGE:-$(git merge-base origin/master HEAD)".."}

# Go to the root of the repo
cd "$(git rev-parse --show-toplevel)"

# Get a list of the current files in package form by querying Bazel.
files=()
for file in $(git diff --name-only ${COMMIT_RANGE} ); do
  files+=($(bazel query $file))
  echo $(bazel query $file)
done

# CI/CD

## Summary

- The CI/CD pipeline runs on a special machine called runner
- The ultimate goal of any CI/CD pipeline is to run some commands on the files of your repository

## Steps/Jobs

- checkout-code
  - the act of securely copying files from your repository to the runner
- check-test-build
  - check for code formatting issues
  - run tests and check for coverage
  - build an executable file
- build-image
  - build a docker image for this executable file
- push-image
  - save the image remotely somewhere(e.g - ECR)
- deploy
  - pull the latest image and run
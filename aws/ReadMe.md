Deployment to AWS Specific
(https://towardsdatascience.com/kubernetes-application-deployment-with-aws-eks-and-ecr-4600e11b2d3c)

1. Ensure the awsCLI is logged into ecr
   - aws ecr get-login-password --region REGION | docker login --username AWS --password-stdin ECR_URI
2.

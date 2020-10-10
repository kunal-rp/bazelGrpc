Deployment to AWS Specific
(https://towardsdatascience.com/kubernetes-application-deployment-with-aws-eks-and-ecr-4600e11b2d3c)

Ensure the awsCLI is logged into ecr

- aws ecr get-login-password --region REGION | docker login --username AWS --password-stdin ECR_URI

Here are the general steps for creating/setup for k8s cluster:

1.  Create Virtal Private Cloud
    -specify public/private subnets(IP's in VPC) for cluster
2.  Create K8s Cluster on said cloud

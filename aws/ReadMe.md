Deployment to AWS Specific
(https://towardsdatascience.com/kubernetes-application-deployment-with-aws-eks-and-ecr-4600e11b2d3c)

Ensure the awsCLI is logged into ecr

- aws ecr get-login-password --region REGION | docker login --username AWS --password-stdin ECR_URI

Here are the general steps for creating/setup for k8s cluster:

1.  Create Virtal Private Cloud
    -specify public/private subnets(IP's in VPC) for cluster
2.  Create K8s Cluster on said cloud
    -note that two services are needed; one to expose the poll service internally, and another to expose the action externally
3.  Be sure to expose the port for the public workers that matches nodeport exposed

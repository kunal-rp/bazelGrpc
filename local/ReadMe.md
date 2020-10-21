The best way to test all of this will be to run minikube node locally and apply the deployments after building services locally.

1. Start minikube
   -minikube start
2. Clear old/Start new deployments
   -kubecbl apply -f DEPLOYMENT.YAML's
3. start services
4. port forwarding for action pod on exposed port
   -this is to simulate calling the cluster for the external(from cluster pods) ip

After editing the new images:

1. Link minikube docker dameon w/ local one 'eval \$(minikube docker-env)'
   -will only work for that terminal , so create a new one and perform all steps
2. Run and create the new images locally, verify w/ 'docker images'
3. set image as REPO+TAG

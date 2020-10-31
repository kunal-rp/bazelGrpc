The best way to test all of this will be to run minikube node locally and apply the deployments after building services locally.

1. Start minikube
   -minikube start
2. Create new images locally
3. Clear old/Start new deployments and services
   -kubecbl apply -f local/
4. Start up ingress add on with minikube
   - 'minikube addons enable ingress'
5. Apply ingress file
6. Modify '/ect/hosts' to route traffic from minikube ip address to specified host name in ingress resource
7. Run local client
   -should be its own java binary i.e.-ActionClient

After editing the new images:

1. Link minikube docker dameon w/ local one 'eval \$(minikube docker-env)'
   -will only work for that terminal , so create a new one and perform all steps
2. Run and create the new images locally, verify w/ 'docker images'
3. set image as REPO+TAG

kubectl apply -f parent/infrustructure/services/currency-service.yml
kubectl apply -f parent/infrustructure/deployments/currency-deployment.yml

kubectl scale deployment currency --replicas=0

kubectl apply -f parent/infrustructure/roles/service-discovery-rolebinding.yml

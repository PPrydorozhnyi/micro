kubectl apply -f infrastructure/services/currency-service.yml
kubectl apply -f infrastructure/deployments/currency-deployment.yml

kubectl apply -f infrastructure/services/ip-service-service.yml
kubectl apply -f infrastructure/deployments/ip-service-deployment.yml

kubectl apply -f infrastructure/services/central-service.yml
kubectl apply -f infrastructure/deployments/central-deployment.yml

kubectl apply -f infrastructure/services/cpu-service.yml
kubectl apply -f infrastructure/deployments/cpu-deployment.yml

kubectl apply -f infrastructure/services/disc-service.yml
kubectl apply -f infrastructure/deployments/disc-deployment.yml

kubectl apply -f infrastructure/services/gpu-service.yml
kubectl apply -f infrastructure/deployments/gpu-deployment.yml

kubectl apply -f infrastructure/services/motherboard-service.yml
kubectl apply -f infrastructure/deployments/motherboard-deployment.yml

kubectl apply -f infrastructure/services/load-balancer.yml

kubectl scale deployment currency --replicas=0

kubectl apply -f infrastructure/roles/service-discovery-rolebinding.yml

kubectl create secret generic db-creds \
  --from-literal user=admin \
  --from-literal password=1234 \
  --from-literal host=12.12.12.12 \
  --from-literal database=database \
  --from-literal port=5049

kubectl patch svc load-balancer -p '{"spec":{"externalTrafficPolicy":"Local"}}'

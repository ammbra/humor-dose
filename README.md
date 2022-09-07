# humor-dose Project Setup

### Provision the database with Helm

You can provision your MySQL instance using Helm charts:

```shell
helm repo add bitnami https://charts.bitnami.com/bitnami
helm install my-release bitnami/mysql
```

## Deploy to Kubernetes

Please run the command below to deploy to Kubernetes
````
mvn clean package -Dquarkus.kubernetes.deploy=true
````

Obtain the path to the deployed service:

````
kubectl get service humor-dose -o jsonpath='{.status.loadBalancer.ingress[0].ip}'
````

Check the memory and CPU consumption:

````
kubectl get --raw /apis/metrics.k8s.io/v1beta1/namespaces/joke/pods/
````

Export URL to the service using:

````
export URL=http://$( kubectl get service fellowship -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
````

Run the hey command bellow to determine how the resource usage:

````
hey -n 100 -c 20 $URL/jokes
````

Check again the memory and CPU consumption:

````
kubectl get --raw /apis/metrics.k8s.io/v1beta1/namespaces/joke/pods/
````
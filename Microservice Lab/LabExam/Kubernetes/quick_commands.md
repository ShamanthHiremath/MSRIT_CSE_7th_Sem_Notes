YAML file templates:

apiVersion: 
kind: Deployment/Pod
metadata:
  name: 
  namespace:
  labels:
    app:
spec:
<!-- this is for 6th and 7th -->
  <!-- containers:
  - name:
    image:
    ports:
    - containerPort:
    command: [ ]
    args: [ ]
    env:
    - name:
      value: -->
  replicas:
    selector:
        matchLabels:
        app:
    template:
      metadata:
        labels:
          app:
        spec:
          containers:
          - name:
            image:
            ports:
            - containerPort:
            command: [ ]
            args: [ ]
            env:
            - name:
              value:

kubectl

create namespace usn
apply -f <file_name>.yaml --namespace=usn
get pods --namespace=usn


1.yaml

expose deployment usn-dep --type=NodePort --port=80 --target-port=80 --name=usn-service --namespace=usn

get svc --namespace=usn

2.yaml

set image deployment/usn nginx=IP:5001/nginx:latest --namespace=usn
describe deploy usn-dep --namespace=usn | grep Image

3.yaml
run usn1 --image=nginx --restart=Never --label=app=v1 --namespace=usn
get pods --show-labels --namespace=usn
get pods -l app=v1 --namespace=usn
label pod usn1 usn2 usn3 app- --namespace=usn

4.5.yaml 
5th has command, args, env (only command), ubuntu image and logs

logs usn-ubuntu --namespace=usn
delete pod usn-ubuntu --namespace=usn

6.yaml

get pods -o wide --namespace=usn
exec -it usn-pod2 -c usn-container --namespace=usn -- /bin/bash/
apt update, apt install curl, curl localhost:80, exit

7.yaml

two files httpd, and ubuntu

get pods -o wide --namespace=usn
exec -it usn-ubuntu-pod --namespace=usn -- /bin/bash/
apt update
apt install curl
curl <httpd_pod_ip>:80
exit
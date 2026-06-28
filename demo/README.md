when we create some project it has code, db, environment, configs related or system 
if we have to give it to our collegues for testing or adding features it might break some functionalities 

that why we have idea of docker 

docker is a tool to achieve containerization
image
container
cmd
docker file
docker hub
volumes
compose

rishabh-developer@rishabh-developer:~$ docker --version
Docker version 29.1.3, build 29.1.3-0ubuntu4.1
rishabh-developer@rishabh-developer:~$ docker run hello-world
failed to connect to the docker API at unix:///var/run/docker.sock; check if the path is correct and if the daemon is running: dial unix /var/run/docker.sock: connect: no such file or directory
rishabh-developer@rishabh-developer:~$ sudo systemctl start docker
[sudo: authenticate] Password:       
rishabh-developer@rishabh-developer:~$ docker run hello-world
Unable to find image 'hello-world:latest' locally
docker: Error response from daemon: failed to resolve reference "docker.io/library/hello-world:latest": failed to do request: Head "https://registry-1.docker.io/v2/library/hello-world/manifests/latest": dial tcp: lookup registry-1.docker.io on 127.0.0.53:53: server misbehaving

Run 'docker run --help' for more information
rishabh-developer@rishabh-developer:~$ docker run hello-world
Unable to find image 'hello-world:latest' locally
latest: Pulling from library/hello-world
4f55086f7dd0: Pull complete 
d5e71e642bf5: Download complete 
Digest: sha256:96498ffd522e70807ab6384a5c0485a79b9c7c08ca79ba08623edcad1054e62d
Status: Downloaded newer image for hello-world:latest

Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
 $ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/get-started/

rishabh-developer@rishabh-developer:~$ docker ps images
docker: 'docker ps' accepts no arguments

Usage:  docker ps [OPTIONS]

Run 'docker ps --help' for more information
rishabh-developer@rishabh-developer:~$ docker images
                                                                                                                                                    i Info →   U  In Use
IMAGE                ID             DISK USAGE   CONTENT SIZE   EXTRA
hello-world:latest   96498ffd522e       25.9kB         9.49kB    U   
rishabh-developer@rishabh-developer:~$ docker images -a
                                                                                                                                                    i Info →   U  In Use
IMAGE                ID             DISK USAGE   CONTENT SIZE   EXTRA
hello-world:latest   96498ffd522e       25.9kB         9.49kB    U   
rishabh-developer@rishabh-developer:~$ docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
rishabh-developer@rishabh-developer:~$ docker ps -a
CONTAINER ID   IMAGE         COMMAND    CREATED          STATUS                      PORTS     NAMES
e6b6e2ad66e3   hello-world   "/hello"   58 seconds ago   Exited (0) 56 seconds ago             vigorous_knuth
rishabh-developer@rishabh-developer:~$ docker help
Usage:  docker [OPTIONS] COMMAND

A self-sufficient runtime for containers

Common Commands:
  run         Create and run a new container from an image
  exec        Execute a command in a running container
  ps          List containers
  build       Build an image from a Dockerfile
  pull        Download an image from a registry
  push        Upload an image to a registry
  images      List images
  login       Authenticate to a registry
  logout      Log out from a registry
  search      Search Docker Hub for images
  version     Show the Docker version information
  info        Display system-wide information

Management Commands:
  builder     Manage builds
  container   Manage containers
  context     Manage contexts
  image       Manage images
  manifest    Manage Docker image manifests and manifest lists
  network     Manage networks
  plugin      Manage plugins
  system      Manage Docker
  trust*      Manage trust on Docker images
  volume      Manage volumes

Swarm Commands:
  swarm       Manage Swarm

Commands:
  attach      Attach local standard input, output, and error streams to a running container
  commit      Create a new image from a container's changes
  cp          Copy files/folders between a container and the local filesystem
  create      Create a new container
  diff        Inspect changes to files or directories on a container's filesystem
  events      Get real time events from the server
  export      Export a container's filesystem as a tar archive
  history     Show the history of an image
  import      Import the contents from a tarball to create a filesystem image
  inspect     Return low-level information on Docker objects
  kill        Kill one or more running containers
  load        Load an image from a tar archive or STDIN
  logs        Fetch the logs of a container
  pause       Pause all processes within one or more containers
  port        List port mappings or a specific mapping for the container
  rename      Rename a container
  restart     Restart one or more containers
  rm          Remove one or more containers
  rmi         Remove one or more images
  save        Save one or more images to a tar archive (streamed to STDOUT by default)
  start       Start one or more stopped containers
  stats       Display a live stream of container(s) resource usage statistics
  stop        Stop one or more running containers
  tag         Create a tag TARGET_IMAGE that refers to SOURCE_IMAGE
  top         Display the running processes of a container
  unpause     Unpause all processes within one or more containers
  update      Update configuration of one or more containers
  wait        Block until one or more containers stop, then print their exit codes

Global Options:
      --config string      Location of client config files (default "/home/rishabh-developer/.docker")
  -c, --context string     Name of the context to use to connect to the daemon (overrides DOCKER_HOST env var and default context set with "docker context use")
  -D, --debug              Enable debug mode
  -H, --host string        Daemon socket to connect to
  -l, --log-level string   Set the logging level ("debug", "info", "warn", "error", "fatal") (default "info")
      --tls                Use TLS; implied by --tlsverify
      --tlscacert string   Trust certs signed only by this CA (default "/home/rishabh-developer/.docker/ca.pem")
      --tlscert string     Path to TLS certificate file (default "/home/rishabh-developer/.docker/cert.pem")
      --tlskey string      Path to TLS key file (default "/home/rishabh-developer/.docker/key.pem")
      --tlsverify          Use TLS and verify the remote
  -v, --version            Print version information and quit

Run 'docker COMMAND --help' for more information on a command.

For more help on how to use Docker, head to https://docs.docker.com/go/guides/
rishabh-developer@rishabh-developer:~$ docker ps -a
CONTAINER ID   IMAGE         COMMAND    CREATED         STATUS                     PORTS     NAMES
e6b6e2ad66e3   hello-world   "/hello"   2 minutes ago   Exited (0) 2 minutes ago             vigorous_knuth
rishabh-developer@rishabh-developer:~$ docker rm e6b6e2ad66e3
e6b6e2ad66e3
rishabh-developer@rishabh-developer:~$ docker rm e6b6e2ad66e3
Error response from daemon: No such container: e6b6e2ad66e3
rishabh-developer@rishabh-developer:~$ docker ps -a
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
rishabh-developer@rishabh-developer:~$ docker images
                                                                                                                                                    i Info →   U  In Use
IMAGE                ID             DISK USAGE   CONTENT SIZE   EXTRA
hello-world:latest   96498ffd522e       25.9kB         9.49kB        
rishabh-developer@rishabh-developer:~$ docker rmi 96498ffd522e
Untagged: hello-world:latest
Deleted: sha256:96498ffd522e70807ab6384a5c0485a79b9c7c08ca79ba08623edcad1054e62d
rishabh-developer@rishabh-developer:~$ docker images
                                                                                                                                                    i Info →   U  In Use
IMAGE   ID             DISK USAGE   CONTENT SIZE   EXTRA
rishabh-developer@rishabh-developer:~$ now we have manual way^C
rishabh-developer@rishabh-developer:~$ docker search hello-world
NAME                                DESCRIPTION                                     STARS     OFFICIAL
hello-world                         Hello World! (an example of minimal Dockeriz…   2581      [OK]
rancher/hello-world                 This container image is no longer maintained…   6         
okteto/hello-world                                                                  0         
atlassian/hello-world                                                               3         
goharbor/hello-world                                                                0         
tutum/hello-world                   Image to test docker deployments. Has Apache…   91        
dockercloud/hello-world             Hello World!                                    20        
crccheck/hello-world                Hello World web server in under 2.5 MB          25        
koudaiii/hello-world                                                                0         
prajwalendra/hello-world                                                            0         
ppc64le/hello-world                 Hello World! (an example of minimal Dockeriz…   2         
tsepotesting123/hello-world                                                         0         
infrastructureascode/hello-world    A tiny "Hello World" web server with a healt…   1         
kevindockercompany/hello-world                                                      0         
arm32v7/hello-world                 Hello World! (an example of minimal Dockeriz…   3         
arm64v8/hello-world                 Hello World! (an example of minimal Dockeriz…   3         
cloudflare/hello-world              A simple example application which can be ru…   0         
datawire/hello-world                Hello World! Simple Hello World implementati…   1         
twistlocktest/hello-world                                                           0         
uniplaces/hello-world                                                               0         
wjimenez5271/hello-world                                                            0         
danfengliu/hello-world                                                              0         
lbadger/hello-world                                                                 0         
ansibleplaybookbundle/hello-world   Simple containerized application that tests …   0         
swarna3005/hello-world                                                              0         
rishabh-developer@rishabh-developer:~$ 

Using default tag: latest
latest: Pulling from library/hello-world
4f55086f7dd0: Pull complete 
d5e71e642bf5: Download complete 
Digest: sha256:96498ffd522e70807ab6384a5c0485a79b9c7c08ca79ba08623edcad1054e62d
Status: Downloaded newer image for hello-world:latest
docker.io/library/hello-world:latest
rishabh-developer@rishabh-developer:~$ docker create hello-world
1aa07fb8fc05d1bdbaded065efd2de43d389b08d1ee40c9a554f9c460c4c57b6
rishabh-developer@rishabh-developer:~$ docker start 1aa0
1aa0
rishabh-developer@rishabh-developer:~$ docker stop 1aa
1aa
rishabh-developer@rishabh-developer:~$ docker ps -a
CONTAINER ID   IMAGE         COMMAND    CREATED          STATUS                      PORTS     NAMES
1aa07fb8fc05   hello-world   "/hello"   47 seconds ago   Exited (0) 29 seconds ago             funny_bhaskara
rishabh-developer@rishabh-developer:~$ docker rm 1aa
1aa
rishabh-developer@rishabh-developer:~$ 


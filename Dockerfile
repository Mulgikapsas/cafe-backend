FROM fedora:33

RUN dnf update -y && \
dnf upgrade -y && \
dnf install -y java-latest-openjdk-headless && \
dnf clean all && \
mkdir -p /opt/app

COPY /target/app-runner.jar /opt/app/

RUN chmod 775 -R /opt/app && \
chown 1001:root -R /opt/app

USER 1001
EXPOSE 8080
WORKDIR /opt/app/
ENTRYPOINT ["/usr/bin/java","-Xmx128m","-jar","app-runner.jar"]

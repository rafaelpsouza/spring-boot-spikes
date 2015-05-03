FROM rafaelpsouza/ubuntu-oracle-java8 
VOLUME /tmp
ADD contract-jax-rs.zip /usr/local/contract-jax-rs.zip
WORKDIR /usr/local
RUN unzip contract-jax-rs.zip
EXPOSE 9000
ENTRYPOINT ["/usr/local/contract-jax-rs/bin/contract-jax-rs"]
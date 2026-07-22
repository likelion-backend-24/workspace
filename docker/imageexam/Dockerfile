FROM ubuntu:latest

RUN echo 'source ~/.bashrc' >> ~/.bash_profile
RUN echo 'export PATH=$PATH:/custom/path' >> ~/.bashrc
RUN echo 'alias ll="ls -lah"' >> ~/.bashrc

CMD [ "/bin/bash" , "-c", "source ~/.bashrc && bash" ]
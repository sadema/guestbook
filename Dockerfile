FROM sadema/payara-micro
ENV ARCHIVE_NAME guestbook.war
COPY ./target/guestbook.war ${DEPLOYMENT_DIR}
ENTRYPOINT java -jar ${PAYARA_ARCHIVE}.jar --deploy ${ARCHIVE_NAME}

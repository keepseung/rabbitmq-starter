# rabbitmq-starter
springboot에 rabbitmq를 연동한 스타터 프로젝트입니다.

#### # 개발 환경
- mac os catalina
- java 11
- rabbitmq client 5.10.0
- rabbitmq server 3.8.9
- spring boot 2.5.5
- gradle 7.2

#### # 파일 소개
- config/MessageConfig.java : Queue, TopicExchange, Binding, Exchange, RabbitTemplate 등 메세지를 보내기 위한 객체 생성
- consumer/User.java : 메세지를 받음
- publish/OrderPublisher : 메세지를 보낸다.

#### # rabbitmq mac 설치
$ brew install rabbitmq

#### # rabbitmq start
$ /usr/local/sbin/rabbitmq-server

#### # rabbitmq manager ui
- http://localhost:15672
- 기본 계정 : guest / guest

#### # rabbitmq 계정 생성
$ /usr/local/sbin/rabbitmqctl add_user {사용자} {비번}

#### # admin 권한 부여
$ /usr/local/sbin/rabbitmqctl set_user_tags {사용자} administrator

#### # 계정 보기
$ /usr/local/sbin/rabbitmqctl list_users

#### # 유저 vhost 권한 부여
예) rabbitmqctl list_permissions [-p vhost ] <user> <conf> <write> <read>
$ /usr/local/sbin/rabbitmqctl set_permissions -p / {사용자} ".*" ".*" ".*"

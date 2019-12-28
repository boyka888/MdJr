# client
springboot
ssh -p 22 root@27.102.107.199

scp -P 22 /Users/gaojiajia/IdeaProjects/client/target/client-1.0.0.jar root@27.102.107.199:/opt/client-1.0.0.jar
netstat -nlp | grep :9099
kill -9 进程id
`nohup java -jar client-1.0.0.jar >temp.txt &`


./certbot-auto certonly --register-unsafely-without-email --webroot -w cert -d mffeex.com

/etc/letsencrypt/live/mffeex.com/fullchain.pem
/etc/letsencrypt/live/mffeex.com/privkey.pem

#手动更新
./certbot-auto  renew   -v


#自动更新
./certbot-auto  renew  --quiet  --no-self-upgrade

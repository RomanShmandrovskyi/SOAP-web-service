# SOAP-Web-Service
## 1. start project
mvn clean install jetty:run
## 2. SaopUI configing
1. Create in SoapUI a new SOAP project (ctrl+N)<br/> 
2. In field "Initial WSDL" put http://localhost:8080/WalletService?wsdl<br/>
3. OK
## 3. Data filling
Try to add some wallets by sending addNewWallet request (5 at least)<br/>
## 4. Web Service opportunities
1. Add new wallet<br/>
2. Buy some goods (you have a credit limit in 50, and you can't exceed it)<br/>
3. Delete wallet by id (if wallet with such id not exist, you will be informed)<br/>
4. Get all wallets (return a list of existing wallet)<br/>
5. Get wallet balance (return balance of current wallet (by id), if wallet with such id dosn't exist, you will be informed)<br/>
6. Put money on balance (you have a max limit in 1000, and you can't exceed it)

# FOR CLIENT CORRECT WORKING DO NOT STOP WEB SERVICE

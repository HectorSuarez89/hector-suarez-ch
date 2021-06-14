# Challenge Wenance
This microservice makes a call every 10 seconds to: https://cex.io/api/last_price/BTC/USD and stores the response in an in-memory database. </br>
Furthermore allows you to get the price at a timestamp. </br>
Also allows to obtain the average price and the percentage difference between the average price and the maximum value obtained in the consulted interval.

##Getting Started
1 - Clone this project ``git clone https://github.com/HectorSuarez89/hector-suarez-ch.git`` </br> 
2 - Go to folder of project and execute ``mvn package`` </br>
3 - Execute project with: ``java -jar target/challenge-0.0.1-SNAPSHOT.jar`` </br>
4 - Open your browser and go to ``localhost:8080/h2-console``</br>
5 - Login on database with ``username: sa`` and ``password: password``</br>
6 - Copy time value of same row in the table prices.</br>
7 - In the terminar execute command ``curl localhost:8080/prices/?time=[time value copied (yyyy-MM-ddThh:mm:ss)]``</br>
8 - You must get response like to: ``{"id":1,"price":39572.3984375,"time":"2021-06-14T04:04:24"} ``</br>
9 - Go to database and copy two values to time. Ej:  ``2021-06-14T04:04:24`` , ``2021-06-14T04:13:33``</br>
10- In the terminar execute command ``curl -sS 'http://localhost:8080/prices/averange?from=2021-06-14T04:04:24&until=2021-06-14T04:13:33' ``</br>
11- You must get response like to: ``{"from":"2021-06-14T04:04:24","until":"2021-06-14T04:13:33","averangeValue":39572.758579799105,"maxValueStored":39580.0,"percentageDiff":-0.0182952880859375}``</br>
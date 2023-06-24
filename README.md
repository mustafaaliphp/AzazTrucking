# AzazTrucking
Add Driver: 
![add](https://github.com/mustafaaliphp/spring-microservice/assets/53540870/1ab175c9-6253-424b-bde6-1e6c5b289f62)
Get All Drivers:
![getAllDrivers](https://github.com/mustafaaliphp/spring-microservice/assets/53540870/a061ff13-e6fd-4b04-8f68-7a3944d07a18)
Error:
![Error](https://github.com/mustafaaliphp/spring-microservice/assets/53540870/88120159-339a-433a-bcf6-8bfb8d91733c)
RequestURL: http://localhost:8080/azinq </br>
Add driver request body:</br>

{
    "callerRequestId":"12122121",
    "callerApplicationName":"AS",
    "callerId":"id",
    "taskName": "addDriver",
    "encodedMessage":"ew0KImxhc3RfbmFtZSI6ICJBbGkiLA0KImZpcnN0X25hbWUiOiAiTXVzdGFmYSIsDQoiZW1haWwiOiAiTXVzdGFmYUB5YWhvby5jb20iLA0KInBob25lIjogIjA1NS0yNDQtNjU3NCIsDQoiYWRkcmVzcyI6ICJTb3V0aCBtYWluIFNUIg0KfQ",
    "additionalInfo": [
        {
            "name":"",
            "value":""
        }
    ]
}

</br>
Response:</br>
{
    "azId": "AZ1687585382742998aa3cf8332422595908dd274cbd844",
    "callerApplicationName": "AS",
    "callerId": "id",
    "taskName": "addDriver",
    "status": "Success",
    "code": "200",
    "encodedMessage": "ZHJpdmVyIGFkZGVk",
    "additionalInfo": []
}
</br>

Get All Drivers Request body: </br>
{
    "callerRequestId":"12122121",
    "callerApplicationName":"AS",
    "callerId":"id",
    "taskName": "getAllDrivers",
    "encodedMessage":"",
    "additionalInfo": [
        {
            "name":"",
            "value":""
        }
    ]
}
</br>

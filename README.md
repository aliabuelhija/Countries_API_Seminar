# Countries API Seminar

**By Ali Abu Elhija and Alaa Badra**

The Countries API provides comprehensive information about countries around the world. By entering the name of a country, you can retrieve its capital, calling code, a small picture of its flag, and the region it belongs to. To make use of this API, follow the steps below:

1. First, you need to obtain an instance of the CountryInfoService. This can be done using the following code snippet:

```java
private CountryInfoService service;
service = CountryInfoService.getInstance();
```

2. An example of how to make a request using the API is shown below. In this case, the `findCapitalByName` method is used to retrieve the capital of a specific country. The `showResult` method is a callback function that handles the response.

```java
service.findCapitalByName(country, this::showResult);
```

3. The definition of the `findCapitalByName` method in the `CountryInfoService` class is as follows:

```java
public void findCapitalByName(String country, CallBack_Country callback);
```

Make sure to replace `country` with the desired country name and implement the `showResult` method according to your needs.

With the above steps, you can effectively utilize the Countries API to retrieve valuable information about countries and enhance your applications with detailed country data.

---
Installation
You can easily add this library to your project by adding the following dependency to your build.gradle file:

	        implementation 'com.github.aliabuelhija:Countries_API_Seminar:1.2'
---
Example:
![image](https://github.com/aliabuelhija/Countries_API_Seminar/assets/100870794/94c5cafe-e536-4c1d-8909-b3ffd719a8c9)
![image](https://github.com/aliabuelhija/Countries_API_Seminar/assets/100870794/d14f7bed-687e-4872-9181-69e4261190cb)

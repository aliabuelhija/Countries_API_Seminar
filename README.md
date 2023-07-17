# Countries API Seminar

**By Ali Abu Elhija and Alaa Badra**

The Countries API provides comprehensive information about countries around the world. By entering the name of a country, you can retrieve its capital, calling code, a small picture of its flag, and the region it belongs to. To make use of this API, follow the steps below:

1. **Installation:** You can easily add this library to your project by adding the following dependency to your build.gradle file:

```groovy
implementation 'com.github.aliabuelhija:Countries_API_Seminar:1.2'
```

2. **Obtain Instance:** First, obtain an instance of the CountryInfoService using the following code snippet:

```java
private CountryInfoService service;
service = CountryInfoService.getInstance();
```

3. **Make a Request:** To retrieve the capital of a specific country, use the `findCapitalByName` method. The `showResult` method is a callback function that handles the response.

```java
service.findCapitalByName(country, this::showResult);
```

4. **Method Definition:** The `findCapitalByName` method in the `CountryInfoService` class is defined as follows:

```java
public void findCapitalByName(String country, CallBack_Country callback);
```

Ensure that you replace `country` with the desired country name and implement the `showResult` method according to your application's requirements.

With the above steps, you can effectively utilize the Countries API to retrieve valuable information about countries and enhance your applications with detailed country data.

---

**Example:**

![image](https://github.com/aliabuelhija/Countries_API_Seminar/assets/100870794/94c5cafe-e536-4c1d-8909-b3ffd719a8c9)

![image](https://github.com/aliabuelhija/Countries_API_Seminar/assets/100870794/d14f7bed-687e-4872-9181-69e4261190cb)

This provides an example of how the API can be used and the images demonstrate the output you can expect.

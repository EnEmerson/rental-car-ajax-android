# rental-car-ajax-android
A demo Rental Car app for Android using Firebase and AJAX restful apis

---

[My firebase for the rental cars](https://android-dev-spring-2019.firebaseio.com/rental-cars.json)

**Make sure the "Rules" for ```.read``` and ```.write``` are both set to ```true``` on your database.**

---

## Common 'meta-data' related issues:

1. Make sure the ```app/manifests/AndroidManifest.xml``` file contains the correct ```<uses-permission>``` It looks like this:

```XML
<uses-permission android:name="android.permission.INTERNET" />
```

***This allows the app to connect to the internet to make the AJAX calls.***

---

2. In the Gradle Scripts, make sure the "build.gradle (Module: app)" file contains the correct dependencies, add this line to your dependencies:

```gradle
implementation 'com.loopj.android:android-async-http:1.4.9'
```

***This allows the RestClient file to access the AJAX libraries.***

---

3. In your "Car" object, ensure that the constructor is getting the correct attribute names from the JSON object that is passed into it, they must be the same names as the ones you assigned on the Firebase.

### Example:

Firebase JSON object:

```JSON
{
"brand":"Subaru",
"color":"Green",
"id":100,
"name":"Outback",
"rent":20.0
}
```

Android Rental Car Constructor:

```Java
 public RentalCar(JSONObject carObject){

        try{
            this.id = carObject.getInt("id");
            this.name = carObject.getString("name");
            this.brand = carObject.getString("brand");
            this.color = carObject.getString("color");
            this.rentCost = (float)carObject.getDouble("rent");
        }
        catch(Exception ex){ex.printStackTrace();}

    }
```

### As you can see, the attributes in the JSON match the attributes (in quotes) in the Java object.

---

![assignment-info](https://github.com/EnEmerson/rental-car-ajax-android/blob/master/resources/assignment-info.png)







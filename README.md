# RupiahEdittext

[![](https://jitpack.io/v/Wildanafian/RupiahEdittext.svg)](https://jitpack.io/#Wildanafian/RupiahEdittext)

Android kotlin based Edittext with rupiah format library

![alt text](https://github.com/Wildanafian/RupiahEdittext/blob/master/Screenshot.png)
![alt text](https://github.com/Wildanafian/RupiahEdittext/blob/master/Screenshot2.png)

## Preparation

**Step 1.** Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency
```
dependencies {
	        implementation 'com.github.Wildanafian:RupiahEdittext:latest-release'
	}
```
  
## How to use
**XML**
```
 <com.wldn.rupiahedittext.RupiahEdittext
        android:id="@+id/etRupiah"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

Note : all behavior is the same as normal edittext
```

**Get Raw Value**
```
 etRupiah.rawValue
```

**Disable rupiah format**
```
 etRupiah.setCurrency(false)
```

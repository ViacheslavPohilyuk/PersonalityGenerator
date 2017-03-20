# PersonalityGenerator
Project for generating random persons and writing their data to the database.  

### Description  
***Firstly***, we getting random person's data from the site <http://randus.ru/> , using its API.  
***Secondly***, we processing person's data:  
           - Transliteration from Cyrillic to Latin letters (**first name, surname, patronymic, city, street**)  
           - Translate favorite person's color from Russian to English  
           - Truncate a double names ("Danil i Daniil" -> "Danil")  
           - Processing string with a person's birthday date to object with type Date ("1 февраля 1981 года" to "01.02.1981")
***Finally***, writting processed person's data to a database

Demonstration:  
https://www.dropbox.com/s/841xtp48kpgm3gm/PersonGeneratorDemo.mov?dl=0

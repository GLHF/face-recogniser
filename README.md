Запустить таск buildZip в градле для создания полного архива с зависимостями.
Залить этот архив как функцию на AWS LAMBDA.
Настроить AWS GATEWAY.

Отправлять изображения как POST запрос на /image. В теле отправлять бинарника изображения. В параметрах 
POST https://rvhzk0gpze.execute-api.us-east-2.amazonaws.com/dev/image?extension=jpg

-Q extension=jpeg
-H Content-Type=image/jpeg
-b бинарник изображения


Ответ:
{
    "url": "http://res.cloudinary.com/dypsks6dr/image/upload/v1608877003/kydbow1th5vesnptfo7e.jpg",
    "faces": [
        {
            "x": 199,
            "y": 271,
            "w": 107,
            "h": 107,
            "url": "http://res.cloudinary.com/dypsks6dr/image/upload/v1608877008/ti2j86cz71qpjlsrhif4.jpg"
        }
    ],
    "total_faces": 1
}
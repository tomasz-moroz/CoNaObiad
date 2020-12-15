<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload</title>
</head>
<body>
<form action="json-upload" method="post">
    <button style="background-color: blue;" type="button">
        I am a blue button! Click me!
    </button>
    <form method="get" action="Adult-check">

        <div style="display: flex; flex-direction: row;">
            <input src="Start" style="margin: auto; display: block; float: none;" class="btn btn-solid" type="submit"
                   name="upload" value="Upload from Url"/>
            <input src="Say-goodbye" style="margin: auto; display: block; float: none;" class="btn btn-solid" type="submit"
                   name="upload" value="Upload from file .json"/>
        </div>

    </form>
</form>
</body>
</html>
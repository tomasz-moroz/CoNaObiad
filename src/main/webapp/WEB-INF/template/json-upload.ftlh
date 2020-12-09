<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Add Json</title>
</head>
<body>
<section class="splash" id="load"
         style="background-image: url('https://images.pexels.com/photos/339696/pexels-photo-339696.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');">

    <div class="page-intro">
        <div class="container">
            <h1 class="main-title">Admin Panel</h1>
            <form action="json-upload" method="post" enctype="multipart/form-data">
                <div style="display: flex; flex-direction: row;">
                    <input style="margin: auto; display: block; float: none;" class="btn btn-solid" type="file"
                           name="drinks">
                    <button style="margin: auto; display: block; float: none;" class="btn btn-solid" type="submit"
                            class="">Upload
                    </button>
                </div>
            </form>

        </div>
    </div>

</section>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login Form | Order Form </title>


    <script type="text/javascript" src="../../js/jquery.js"></script>
    <script type="text/javascript" src="../../js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="../../js/bootstrap.js"></script>


    <!-- Bootstrap Core CSS -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/jquery-ui.min.css" rel="stylesheet">
    <link href="../../css/jquery-ui.theme.min.css" rel="stylesheet">
    <link href="../../css/jquery-ui.structure.min.css" rel="stylesheet">
    <link href="../../css/bootstrap.css" rel="stylesheet">


    <script>
        $("#login-form").dialog({
            modal: true,
            draggable: false,
            resizable: false,
            position: ['center', 'top'],
            show: 'blind',
            hide: 'blind',
            width: 400,
            dialogClass: 'ui-dialog-osx',
            buttons: {
                "I've read and understand this": function () {
                    $(this).dialog("close");
                }
            }
        });
    </script>
</head>

<div id="login-form">
    <form method="post" action='' name="login_form">
        <p><input type="text" class="span3" name="userName" id="email" placeholder="Email" value="${userName!}">
        </p>
        <p><input type="password" class="span3" name="password" placeholder="Password"></p>
        <p>
            <button type="submit" class="btn btn-primary">Sign in</button>
            <a href="#">Forgot Password?</a>
        </p>
    </form>
</div>

</html>
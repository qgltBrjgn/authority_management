<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<title>test</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<!-- BEGIN BODY -->
<body class="login">
hello!!!annotation!!!
<div id="tb">
    <#if permissions??>
        <#if permissions?seq_contains("111")>
            <div>测试1</div>
        </#if>
        <#if permissions?seq_contains("222")>
            <div>测试2</div>
        </#if>
        <#if permissions?seq_contains("333")>
            <div>测试3</div>
        </#if>
    </#if>
</div>
</body>
<!-- END BODY -->
</html>
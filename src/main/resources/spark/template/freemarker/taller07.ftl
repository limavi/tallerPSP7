<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
}
</style>
</head>
<body>
<h2> Taller #7 </h2>

<h4>Test1 </h4>
${test1?html?replace("\n", "<br>")}

<h4>Test2 </h4>
${test2}

<h4>Test3 </h4>
${test3}

<h4>Test4 </h4>
${test4}


</body>
</html>
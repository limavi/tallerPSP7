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
<table>
    <tr>
        <td>Test</td>
        <td>Tesultado</td>
    </tr>
    <tr>
        <td>Test 1</td>
        <td>${test1?html?replace(',', '<br>')}</td>
    </tr>
</table>

<h4>Test1 </h4>
${test1?html?replace(',', '<br>')}
ogot
<h4>Test2 </h4>
${test2?html?replace(',', '<br>')}

<h4>Test3 </h4>
${test3?html?replace(',', '<br>')}

<h4>Test4 </h4>
${test4?html?replace(',', '<br>')}

</body>
</html>
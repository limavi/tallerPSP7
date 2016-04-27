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
        <td>Resultado</td>
    </tr>
    <tr>
        <td>Test 1</td>
        <td>${test1?html?replace(',', '<br>')}</td>
    </tr>
    <tr>
        <td>Test 2</td>
        <td>${test2?html?replace(',', '<br>')}</td>
    </tr>
    <tr>
        <td>Test 3</td>
        <td>${test3?html?replace(',', '<br>')}</td>
    </tr>
    <tr>
        <td>Test 4</td>
        <td>${test4?html?replace(',', '<br>')}</td>
    </tr>
</table>

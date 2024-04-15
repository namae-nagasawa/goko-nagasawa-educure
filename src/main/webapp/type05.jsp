<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<%
double h;
h = 2.5; //halfの頭文字を変数名にしました　宣言と代入を別々にしたバージョン

double p=3.14;//percentの頭文字を変数名にしました 初期化バージョン

out.println("半径が2.5cmの円の面積は"+ (h*h*p) + "です。" );
%>
</body>
</html>
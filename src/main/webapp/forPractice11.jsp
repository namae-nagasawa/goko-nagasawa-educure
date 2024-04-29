<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for (int k = 0; k < 5; k++) {

	for (int i = 0; i <= 9; i++) {
		if (i == 0 || i == 9) {
	out.print("*");
		} else {
	out.print(" ");
		}
	}
}
out.println(" ");
for (int k = 0; k < 5; k++) {
	for (int i = 0; i <= 9; i++) {
		if (i == 0 || i == 1 || i == 8 || i == 9) {
	out.print("*");
		} else {
	out.print(" ");
		}
	}
}
out.println(" ");
for (int k = 0; k < 5; k++) {
	for (int i = 0; i <= 9; i++) {
		if ((i >= 0 && i <= 2) || (i >= 7 && i <= 9)) {
	out.print("*");
		} else {
	out.print(" ");
		}
	}
}
out.println(" ");
for (int k = 0; k < 5; k++) {
	for (int i = 0; i <= 9; i++) {
		if ((i >= 0 && i <= 3) || (i >= 6 && i <= 9)) {
	out.print("*");
		} else {
	out.print(" ");
		}
	}
}
out.println(" ");
for (int k = 0; k < 5; k++) {
	for (int i = 0; i <= 9; i++) {
		if ((i >= 0 && i <= 4) || (i >= 5 && i <= 9)) {
	out.print("*");
		} else {
	out.print(" ");
		}
	}
}
out.println(" ");
for (int k = 0; k < 5; k++) {
	for (int i = 0; i <= 9; i++) {
		if ((i >= 0 && i <= 3) || (i >= 6 && i <= 9)) {
	out.print("*");
		} else {
	out.print(" ");
		}
	}
}
out.println(" ");
for (int k = 0; k < 5; k++) {
	for (int i = 0; i <= 9; i++) {
		if ((i >= 0 && i <= 2) || (i >= 7 && i <= 9)) {
	out.print("*");
		} else {
	out.print(" ");
		}
	}
}
out.println(" ");
for (int k = 0; k < 5; k++) {
	for (int i = 0; i <= 9; i++) {
		if ((i >= 0 && i <= 1) || (i >= 8 && i <= 9)) {
	out.print("*");
		} else {
	out.print(" ");
		}
	}
}
out.println(" ");
for (int k = 0; k < 5; k++) {
	for (int i = 0; i <= 9; i++) {
		if (i == 0 || i == 9) {
	out.print("*");
		} else {
	out.print(" ");
		}
	}
}
out.println(" ");
%>
</body>
</html>

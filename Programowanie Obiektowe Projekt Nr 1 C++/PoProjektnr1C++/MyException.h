#pragma once
class MyException
{
public:
	const char* text;
	MyException(const char *omikron);
	~MyException();
};
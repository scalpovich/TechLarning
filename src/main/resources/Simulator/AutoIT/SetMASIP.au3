#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
	WinActivate($CmdLine[1], "Test Options")
	ControlClick($CmdLine[1], "", "[NAME:optserverclient_11]")
	Send("{TAB}")
	Sleep(300)
	Send("^a")
	Send($CmdLine[2])
	Sleep(300)
	Send("{TAB}")
	Sleep(300)
	Send($CmdLine[3])
	Sleep(300)
	Send($CmdLine[4])
	Sleep(300)
	Send($CmdLine[5])
	Sleep(300)
	Send($CmdLine[6])

	ControlClick($CmdLine[1], "", "[NAME:cmdSave_1]")
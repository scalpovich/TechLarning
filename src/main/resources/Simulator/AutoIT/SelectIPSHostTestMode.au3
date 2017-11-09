#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
Opt("WinWaitDelay", 500) ;250 milliseconds

If WinExists("MasterCard Authorization Simulator <MAS16.Q4>") Then
   WinActivate("MasterCard Authorization Simulator <MAS16.Q4>", "Test Mode")
	ControlClick("MasterCard Authorization Simulator <MAS16.Q4>","","[NAME:comboBox1]")
	Sleep(1000)
	Send("{DOWN}")
	Sleep(1000)
	Send("{ENTER}")
	Sleep(10000)
EndIf

#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#RequireAdmin
#include <AutoItConstants.au3>


	WinActivate("MCPS - MasterCard Clearing Presentment Simulator - 16.Q4", "TDG")
	ControlClick("MCPS - MasterCard Clearing Presentment Simulator - 16.Q4", "", "TDG")
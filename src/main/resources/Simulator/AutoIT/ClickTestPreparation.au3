#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#include <AutoItConstants.au3>


	WinActivate("MasterCard Authorization Simulator <MAS16.Q4>", "Test Options")
	ControlClick("MasterCard Authorization Simulator <MAS16.Q4>", "", "Allows preparing the test cases")

	WinWait("MasterCard Authorization Simulator <MAS16.Q4>", "[NAME:TabStrip]", "60")
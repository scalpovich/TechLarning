#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------
   ; Script Start - Add your code below here
   #include <MsgBoxConstants.au3>
   #include <WinAPIFiles.au3>
   #include <Constants.au3>

    sleep(2000)
   ;sometimes an Information dialog comes up on which we have to click on OK
    WinActivate("Information")
    ControlClick("Information", "", "OK")

    WinActivate("Test Execution (1)")
    ControlClick("Test Execution (1)", "", "[CLASS:Button; INSTANCE:15]")

	WinActivate("VTS Communications Handler (1)")

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

	While 1
	    ; checking to read text "1" from Recieved Messages - Total
	 Local $sText = ControlGetText ("Test Execution (1)", "", "[CLASS:Static; INSTANCE:15]")
	 Sleep(1000)
    If $sText = "1" Then
	   Sleep(5000)
        ExitLoop
	 EndIf
	 Sleep(1000)
 WEnd
 Sleep(10000)
    ControlClick("Test Execution (1)", "", "[CLASS:Button; INSTANCE:15]")
	Sleep(10000)
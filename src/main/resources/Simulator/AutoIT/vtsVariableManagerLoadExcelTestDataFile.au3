 #include <MsgBoxConstants.au3>
   #include <WinAPIFiles.au3>
   #include <Constants.au3>


   WinActivate("Variables Manager")
   WinMenuSelectItem("Variables Manager", "", "&File", "&Import from Excel Document")
   sleep(4000)

    ControlSetText("Open","","[CLASS:Edit; INSTANCE:1]", $CmdLine[1]) ; setting text in the path section
   sleep(1000)
   ControlClick("Open","","[CLASS:Button; INSTANCE:1]") ; click on Open button
   sleep(15000)

   WinWaitActive("Variables Manager")

   While ProceedClickOK() <> 1
	  WEnd


Func ProceedClickOK()
  If ControlCommand ("Variables Manager", "", "[CLASS:Button; INSTANCE:1]", "IsEnabled") Then
    ControlClick("Variables Manager","","[CLASS:Button; INSTANCE:1]")
	Sleep(1000)
	If ControlCommand ("Variables Manager", "", "OK", "IsEnabled") Then
	  ControlClick("Variables Manager","","OK")
	EndIf
    WinMenuSelectItem("Variables Manager", "", "&File", "E&xit") ; closing the window
	  ; code to close "Save yes or no" dialog incases changes are made
	  If ControlCommand ("Variables Manager", "", "&Yes", "IsVisible") Then
		 ControlClick("Variables Manager","","&Yes") ; to handle OK dialog that may sometimes come up
		 Sleep(1000)
	  EndIf

    sleep(3000)
    WinWaitClose("Variables Manager")
    Return 1
  EndIf
  Return 0
EndFunc
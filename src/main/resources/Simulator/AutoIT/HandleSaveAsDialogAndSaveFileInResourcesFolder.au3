#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#RequireAdmin
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>

If WinExists("Save As") Then
	WinActivate("Save As", "&Save")
	sleep(500)
	Local $sText = ControlGetText("Save As","","[CLASS:Edit; INSTANCE:1]") ;Get the file name before we erase it

   $filedir =@ScriptDir ;Directory within the Appdata directory where the ini file should be.
   $filename = $sText;

   $filePath = StringReplace($filedir, "\Simulator\AutoIT", "") & "\" & $filename

    ; Delete the temporary file.
    FileDelete($filePath)

	sleep(1000)
	ControlSetText("Save As","","[CLASS:Edit; INSTANCE:1]","") ; erase the file name to make room for the $dest string
	sleep(1000)
    ControlSetText("Save As","","[CLASS:Edit; INSTANCE:1]", $filePath) ; set the Edit1 text to the $dest and hit the button to swithc directories.
    sleep(1000)
    ControlClick("Save As","","[CLASS:Button; INSTANCE:1]")
    sleep(2000)
	WinActivate("Generate Text File", "OK")
	 sleep(1000)
	ControlClick("Generate Text File","","[NAME:Cmd_OK]")
	sleep(2000)

    WinActivate("Open with", "&Browse...")
    sleep(1000)
	ControlClick("Open with","","[CLASS:Button; INSTANCE:4]")

   $filedir =@ScriptDir ;Directory within the Appdata directory where the ini file should be.
   $filename = "LatestAuthFileDetails.txt" ;Ini file name.

   $filePath = StringReplace($filedir, "\Simulator\AutoIT", "") & "\" & $filename

    ; Delete the temporary file.
    FileDelete($filePath)

	FileWrite($filePath, $sText)

EndIf


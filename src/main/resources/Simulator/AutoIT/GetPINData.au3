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

If WinExists("PIN Offset Calculator") Then
	WinActivate("PIN Offset Calculator", "Card Number :")
	Local $sText = ControlGetText ("PIN Offset Calculator", "", "[CLASS:Static; INSTANCE:14]")

   $filedir =@ScriptDir ;Directory within the Appdata directory where the ini file should be.
   $filename = "PINData.txt" ;Ini file name.

   $filePath = StringReplace($filedir, "\Simulator\AutoIT", "") & "\" & $filename

    ; Delete the temporary file.
    FileDelete($filePath)


	FileWrite($filePath, $sText)
EndIf


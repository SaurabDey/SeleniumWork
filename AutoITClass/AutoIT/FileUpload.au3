ControlFocus("Open","","ToolbarWindow322")
ControlSetText("Open","","ToolbarWindow322",@WorkingDir & $CmdLineRaw)
Send("{ENTER}")
Sleep(5000)
ControlFocus("Open","","Edit1")
ControlSetText("Open","","Edit1", @WorkingDir & $CmdLineRaw & "\image.jpg")
ControlClick("Open","","Button1")


# Sample module in the public domain. Feel free to use this as a template
# for your modules (and you can remove this header and take complete credit
# and liability)
#
# Contact: Brian Carrier [carrier <at> sleuthkit [dot] org]
#
# This is free and unencumbered software released into the public domain.
#
# Anyone is free to copy, modify, publish, use, compile, sell, or
# distribute this software, either in source code form or as a compiled
# binary, for any purpose, commercial or non-commercial, and by any
# means.
#
# In jurisdictions that recognize copyright laws, the author or authors
# of this software dedicate any and all copyright interest in the
# software to the public domain. We make this dedication for the benefit
# of the public at large and to the detriment of our heirs and
# successors. We intend this dedication to be an overt act of
# relinquishment in perpetuity of all present and future rights to this
# software under copyright law.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
# EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
# MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
# IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
# OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
# ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
# OTHER DEALINGS IN THE SOFTWARE.

import os
import jarray
from java.lang import System
from java.io import File
from org.sleuthkit.datamodel import SleuthkitCase
from org.sleuthkit.datamodel import AbstractFile
from org.sleuthkit.datamodel import ReadContentInputStream
from org.sleuthkit.datamodel import BlackboardArtifact
from org.sleuthkit.datamodel import BlackboardAttribute
from org.sleuthkit.autopsy.ingest import IngestModule
from org.sleuthkit.autopsy.ingest import DataSourceIngestModule
from org.sleuthkit.autopsy.ingest import FileIngestModule
from org.sleuthkit.autopsy.ingest import IngestModuleFactoryAdapter
from org.sleuthkit.autopsy.ingest import IngestModuleIngestJobSettings
from org.sleuthkit.autopsy.ingest import IngestModuleIngestJobSettingsPanel
from org.sleuthkit.autopsy.ingest import IngestMessage
from org.sleuthkit.autopsy.ingest import IngestServices
from org.sleuthkit.autopsy.casemodule import Case
from org.sleuthkit.autopsy.casemodule.services import Services
from org.sleuthkit.autopsy.casemodule.services import FileManager
from org.sleuthkit.autopsy.datamodel import ContentUtils
from org.sleuthkit.autopsy.coreutils import Logger

# Sample factory that defines basic functionality and features of the module
class SampleJythonIngestModuleFactory(IngestModuleFactoryAdapter):
    
    def getModuleDisplayName(self):
        return "Sample Jython File Ingest Module"
    
    def getModuleDescription(self):
        return "A sample ingest module with user-configurable settings"
    
    def getModuleVersionNumber(self):
        return "1.0"
    
    def getDefaultIngestJobSettings(self):
        logger = Logger.getLogger("SampleJythonIngestModuleFactory")
        logger.info("In getDefaultIngestJobSettings()")
        return SampleIngestModuleSettings()

    def hasIngestJobSettingsPanel(self):
        logger = Logger.getLogger("SampleJythonIngestModuleFactory")
        logger.info("In hasIngestJobSettingsPanel()")
        return True

    def getIngestJobSettingsPanel(self, settings):
        logger = Logger.getLogger("SampleJythonIngestModuleFactory")
        logger.info("In getIngestJobSettingsPanel()")
        settings = SampleIngestModuleSettings()
        panel = SampleIngestModuleSettingsPanel(settings)
        return panel
        #return SampleIngestModuleSettingsPanel(SampleIngestModuleSettingsPanel())
			
    def isFileIngestModuleFactory(self):
        logger = Logger.getLogger("SampleJythonIngestModuleFactory")
        logger.info("In isFileIngestModuleFactory()")
        return True
    
    def createFileIngestModule(self, settings):
        logger = Logger.getLogger("SampleJythonIngestModuleFactory")
        logger.info("In createFileIngestModule()")
        return SampleJythonFileIngestModule(SampleIngestModuleSettings())

class SampleIngestModuleSettings(IngestModuleIngestJobSettings):

	def __init__(self):
            self.flag = False

	def getVersionNumber(self):
            return 1
		
	def getFlag(self):
            return self.flag
		
	def setFlag(self, flag):
            self.flag = flag
		
class SampleIngestModuleSettingsPanel(IngestModuleIngestJobSettingsPanel):

	def __init__(self, settings):
            self.settings = settings
            self.checkbox = JCheckBox("Flag")
            self.add(self.checkbox)
            logger = Logger.getLogger("SampleIngestModuleSettingsPanel")
            logger.info("Added check box to panel")

	def getSettings(self):
            logger = Logger.getLogger("SampleIngestModuleSettingsPanel")
            logger.info("getSettings() for panel")
            return SampleIngestModuleSettings()

		
class SampleJythonFileIngestModule(FileIngestModule):

	def __init__(self, settings):
            self.settings = settings

	def startUp(self, context):
            # Log the flag setting
            logger = Logger.getLogger("SampleJythonFileIngestModule")
            if self.settings.getFlag():
                    logger.info("flag is set")
            else:
                    logger.info("flag is not set")

	def process(self, file):
            return IngestModule.ProcessResult.OK

	def shutDown(self):
            pass



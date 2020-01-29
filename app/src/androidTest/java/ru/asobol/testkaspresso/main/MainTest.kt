package ru.asobol.testkaspresso.main

import android.Manifest
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.kaspresso.testcases.api.scenario.BaseScenario
import com.kaspersky.kaspresso.testcases.core.testcontext.*
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainTest : TestCase() {

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun test() {
        before {
            activityTestRule.launchActivity(null)
        }.after {
            testLogger.i("test has been complete")
        }
            .run {
                step("Open Main Screen") {
                    testLogger.i("test open main screen...")
                    MainScreen {
                        text {
                            isVisible()
                            hasText("1")
                        }

                        button {
                            isVisible()
                            click()
                        }

                        text {
                            hasText("2")
                        }
                    }
                }

                step("Test check click button scenario") {
                    testLogger.i("testing main scenario")
                    scenario(CheckClickButtonScenario())
                }
            }
    }
}

class CheckClickButtonScenario<ScenarioData> : BaseScenario<ScenarioData>() {
    override val steps: TestContext<ScenarioData>.() -> Unit = {

        step("Click button and check text") {
            MainScreen {
                text {
                    isVisible()
                    hasText("1")
                }

                button {
                    isVisible()
                    click()
                }

                text {
                    hasText("2")
                }
            }
        }

        step("Click button 3 times and check text") {
            MainScreen {
                text {
                    isVisible()
                    hasText("1")
                }

                button {
                    isVisible()
                    click()
                    click()
                    click()
                }

                text {
                    hasText("4")
                }
            }
        }
    }
}
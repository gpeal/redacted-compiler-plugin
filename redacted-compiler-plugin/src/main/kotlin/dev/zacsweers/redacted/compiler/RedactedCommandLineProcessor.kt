/*
 * Copyright (C) 2021 Zac Sweers
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.zacsweers.redacted.compiler

import com.google.auto.service.AutoService
import org.jetbrains.kotlin.compiler.plugin.AbstractCliOption
import org.jetbrains.kotlin.compiler.plugin.CliOption
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.config.CompilerConfigurationKey

internal val KEY_ENABLED = CompilerConfigurationKey<Boolean>("enabled")
internal val KEY_REPLACEMENT_STRING = CompilerConfigurationKey<String>("replacementString")
internal val KEY_REDACTED_ANNOTATION = CompilerConfigurationKey<String>("redactedAnnotation")

@AutoService(CommandLineProcessor::class)
class RedactedCommandLineProcessor : CommandLineProcessor {

  override val pluginId: String = "redacted-compiler-plugin"

  override val pluginOptions: Collection<AbstractCliOption> =
      listOf(
          CliOption("enabled", "<true | false>", "", required = true),
          CliOption("replacementString", "String", "", required = true),
          CliOption("redactedAnnotation", "String", "", required = true))

  override fun processOption(
      option: AbstractCliOption,
      value: String,
      configuration: CompilerConfiguration
  ) =
      when (option.optionName) {
        "enabled" -> configuration.put(KEY_ENABLED, value.toBoolean())
        "replacementString" -> configuration.put(KEY_REPLACEMENT_STRING, value)
        "redactedAnnotation" -> configuration.put(KEY_REDACTED_ANNOTATION, value)
        else -> error("Unknown plugin option: ${option.optionName}")
      }
}

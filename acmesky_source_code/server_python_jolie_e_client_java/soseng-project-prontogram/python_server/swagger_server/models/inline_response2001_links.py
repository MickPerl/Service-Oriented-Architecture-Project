# coding: utf-8

from __future__ import absolute_import
from datetime import date, datetime  # noqa: F401

from typing import List, Dict  # noqa: F401

from swagger_server.models.base_model_ import Model
from swagger_server import util


class InlineResponse2001Links(Model):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    def __init__(self, _self: str=None, next: str=None, prev: str=None):  # noqa: E501
        """InlineResponse2001Links - a model defined in Swagger

        :param _self: The _self of this InlineResponse2001Links.  # noqa: E501
        :type _self: str
        :param next: The next of this InlineResponse2001Links.  # noqa: E501
        :type next: str
        :param prev: The prev of this InlineResponse2001Links.  # noqa: E501
        :type prev: str
        """
        self.swagger_types = {
            '_self': str,
            'next': str,
            'prev': str
        }

        self.attribute_map = {
            '_self': 'self',
            'next': 'next',
            'prev': 'prev'
        }
        self.__self = _self
        self._next = next
        self._prev = prev

    @classmethod
    def from_dict(cls, dikt) -> 'InlineResponse2001Links':
        """Returns the dict as a model

        :param dikt: A dict.
        :type: dict
        :return: The inline_response_200_1_links of this InlineResponse2001Links.  # noqa: E501
        :rtype: InlineResponse2001Links
        """
        return util.deserialize_model(dikt, cls)

    @property
    def _self(self) -> str:
        """Gets the _self of this InlineResponse2001Links.

        Link al blocco corrente in senso temporale  # noqa: E501

        :return: The _self of this InlineResponse2001Links.
        :rtype: str
        """
        return self.__self

    @_self.setter
    def _self(self, _self: str):
        """Sets the _self of this InlineResponse2001Links.

        Link al blocco corrente in senso temporale  # noqa: E501

        :param _self: The _self of this InlineResponse2001Links.
        :type _self: str
        """

        self.__self = _self

    @property
    def next(self) -> str:
        """Gets the next of this InlineResponse2001Links.

        Link al blocco successivo in senso temporale  # noqa: E501

        :return: The next of this InlineResponse2001Links.
        :rtype: str
        """
        return self._next

    @next.setter
    def next(self, next: str):
        """Sets the next of this InlineResponse2001Links.

        Link al blocco successivo in senso temporale  # noqa: E501

        :param next: The next of this InlineResponse2001Links.
        :type next: str
        """

        self._next = next

    @property
    def prev(self) -> str:
        """Gets the prev of this InlineResponse2001Links.

        Link al blocco precedente in senso temporale  # noqa: E501

        :return: The prev of this InlineResponse2001Links.
        :rtype: str
        """
        return self._prev

    @prev.setter
    def prev(self, prev: str):
        """Sets the prev of this InlineResponse2001Links.

        Link al blocco precedente in senso temporale  # noqa: E501

        :param prev: The prev of this InlineResponse2001Links.
        :type prev: str
        """

        self._prev = prev
